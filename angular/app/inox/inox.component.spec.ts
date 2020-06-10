import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InoxComponent } from './inox.component';

describe('InoxComponent', () => {
  let component: InoxComponent;
  let fixture: ComponentFixture<InoxComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InoxComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InoxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
