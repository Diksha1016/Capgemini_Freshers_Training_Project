import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IylexComponent } from './iylex.component';

describe('IylexComponent', () => {
  let component: IylexComponent;
  let fixture: ComponentFixture<IylexComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IylexComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IylexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
