import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowAlltheaterComponent } from './show-alltheater.component';

describe('ShowAlltheaterComponent', () => {
  let component: ShowAlltheaterComponent;
  let fixture: ComponentFixture<ShowAlltheaterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowAlltheaterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowAlltheaterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
