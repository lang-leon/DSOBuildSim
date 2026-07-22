import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuildSimButton } from './build-sim-button';

describe('BuildSimButton', () => {
  let component: BuildSimButton;
  let fixture: ComponentFixture<BuildSimButton>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BuildSimButton],
    }).compileComponents();

    fixture = TestBed.createComponent(BuildSimButton);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
